package com.midas2018mobile5.mobileapp.main.service;

import android.app.Notification;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.WorkerThread;
import android.util.Log;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.utils.NotificationHelper;
import com.midas2018mobile5.mobileapp.main.utils.PrefManager;

import org.eclipse.paho.android.service.MqttService;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MidasCafePushService extends MqttService implements MqttCallbackExtended, IMqttActionListener, IMqttMessageListener {
    private String clientID;
    private MqttAsyncClient midasPushservice;
    private static final String TAG = "[MidasCafe_PUSH]";
    private static String msgBox;
    private PrefManager manager;

    public MidasCafePushService() {
        this.clientID = "MIDASCafeClient";
    }

    @Override
    public void onCreate() {
        manager = new PrefManager(this);
        String ip_addr = "tcp://192.168.0.35:1883";
        MqttConnectOptions pushoptions = new MqttConnectOptions();
        pushoptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        pushoptions.setAutomaticReconnect(true);
        pushoptions.setCleanSession(true);
        pushoptions.setUserName(clientID);

        msgBox = "MIDASCafe_" + manager.getPrefString("userid");
        Log.e(TAG, msgBox);

        try {
            midasPushservice = new MqttAsyncClient(ip_addr, clientID, new MemoryPersistence());
            midasPushservice.connect(null, this);
        } catch (MqttException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        try {
            midasPushservice.disconnect();
        } catch (MqttException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Debug 용... 이 코드가 존재하면 서비스 실행시
        // 실행 중 표시가 사라지지 않음.
        startForeground(1, new Notification());
        return START_STICKY;
    }

    public void stackVerCheck(String message) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notifyMessageGreater22(message);
        } else {
            notifyMessageUnder21(message);
        }
    }

    /**
     * Method notifyMessageGreater22
     *
     * Android 5.0 이상 플랫폼에서 Notification 사용
     * @param message 전달할 메시지
     */
    @SuppressWarnings("deprecation")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void notifyMessageGreater22(String message) {
        Uri ringtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_RINGTONE);
        NotificationHelper helper = new NotificationHelper(this);
        helper.setNotificationText(getString(R.string.app_name), message);
        helper.setRingtoneUri(ringtoneUri);
        helper.setCategoryAndVisibility(Notification.CATEGORY_EVENT, Notification.VISIBILITY_PUBLIC);
        helper.notify(1412);
    }

    /**
     * Method notifyMessageUnder21
     *
     * Android 5.0 이하 플랫폼에서 Notification 사용
     * @param message 전달할 메시지
     */
    @SuppressWarnings("deprecation")
    private void notifyMessageUnder21(String message) {
        // Uri ringtoneUri = Uri.parse(getPrefManager().getPrefString(getString(R.string.noti_ringtone)));
        NotificationHelper helper = new NotificationHelper(this);
        helper.setNotificationText(getString(R.string.app_name), message);
        // helper.setRingtoneUri(ringtoneUri);
    }

    @WorkerThread
    @Override
    public void onSuccess(IMqttToken asyncActionToken) {
        midasPushservice.setCallback(this);
        try {
            Log.i(TAG, "Success");
            midasPushservice.subscribe(msgBox, 2, this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {

    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        if(reconnect)
            Log.d(TAG, "Reconnection Success !!");
        else
            Log.d(TAG, "Connection is established....");
    }

    @Override
    public void connectionLost(Throwable cause) {
        Log.e(TAG, "The Connection is Lost..." + cause.getCause());
        cause.printStackTrace();
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        Log.i(TAG, new String(message.getPayload()));
        if(topic.equals(msgBox))
            stackVerCheck(new String(message.getPayload()));
        else
            Log.e(TAG, new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        Log.d(TAG, "Sent Message !");
    }
}
