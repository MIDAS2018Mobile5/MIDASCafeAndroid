package com.midas2018mobile5.mobileapp.main.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ClearEditText extends AppCompatEditText implements TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {
    private Drawable clearDrawable;
    private OnFocusChangeListener onFocusChangeListener;
    private OnTouchListener onTouchListener;

    public ClearEditText(final Context context) {
        super(context);
        init();
    }

    public ClearEditText(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearEditText(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener listener) {
        this.onFocusChangeListener = listener;
    }

    @Override
    public void setOnTouchListener(OnTouchListener listener) {
        this.onTouchListener = listener;
    }

    private void init() {
        Drawable tempDrawable = ContextCompat.getDrawable(getContext(), android.support.v7.appcompat.R.drawable.abc_ic_clear_material);
        clearDrawable = DrawableCompat.wrap(tempDrawable);
        DrawableCompat.setTintList(clearDrawable, getHintTextColors());
        clearDrawable.setBounds(0, 0, clearDrawable.getIntrinsicWidth(), clearDrawable.getIntrinsicHeight());

        setClearIconVisible(false);

        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    /**
     * Callback Method onFocusChange
     *
     * EditBox 에 커서가 있을 경우에만 x 버튼을 표시합니다
     * @param view 현재 view
     * @param hasFocus 텍스트 커서 여부
     */
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus)
            setClearIconVisible(getText().length() > 0);
        else
            setClearIconVisible(false);

        if(onFocusChangeListener != null)
            onFocusChangeListener.onFocusChange(view, hasFocus);
    }


    /**
     * Callback Method onTouch
     *
     * X 버튼을 터치햇을 경우, EditBox 에 있는 모든 내용을 제거합니다
     *
     * @param view 현재 view
     * @param event 터치 이벤트
     * @return 이벤트 발생 여부
     */
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int x = (int)event.getX();
        if(clearDrawable.isVisible() && x > getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth()) {
            if(event.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText(null);
            }
            return true;
        }

        if(onTouchListener != null)
            return onTouchListener.onTouch(view, event);
        else
            return false;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(isFocused())
            setClearIconVisible(charSequence.length() > 0);
    }

    private void setClearIconVisible(boolean visible) {
        clearDrawable.setVisible(visible, false);
        setCompoundDrawables(null, null, visible ? clearDrawable : null, null);
    }
}
