package com.siasun.myricheditor.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.siasun.myricheditor.R;

import jp.wasabeef.richeditor.RichEditor;

public class IRichEditor extends LinearLayout {

    private final static String TAG = IRichEditor.class.getSimpleName();

    private int textBackgroundColor;
    private String hintText;
    private int defTextColor;
    private float defTextSize;

    ImageButton actionSudo;
    ImageButton actionRedo;
    ImageButton actionBold;
    ImageButton actionItalic;
    ImageButton actionStrikeThrough;
    ImageButton actionUnderLine;
    ImageButton actionHead1;
    ImageButton actionHead2;
    ImageButton actionHead3;
    ImageButton actionHead4;
    ImageButton actionHead5;
    ImageButton actionHead6;
    ImageButton actionNumber;
    ImageButton actionImage;
    ImageButton actionVideo;

    Context context;

    RichEditor richEditor;

    /**
     * 在java代码里new的时候会用到
     *
     * @param context 上下文
     */
    public IRichEditor(Context context) {
        super(context);
        initView(context);
    }

    /**
     * 在xml布局文件中使用时自动调用
     *
     * @param context 上下文
     */

    public IRichEditor(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttrs(context, attrs);
    }

    /**
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     *
     * @param context      上下文
     * @param attrs        参数
     * @param defStyleAttr 默认的 style 参数
     */

    public IRichEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttrs(context, attrs);
    }

    /**
     * 只有在API版本>21时才会用到
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     *
     * @param context      上下文
     * @param attrs        参数
     * @param defStyleAttr 默认 style 参数
     * @param defStyleRes  默认 style 资源
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public IRichEditor(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.view_iricheditor, this, true);
        actionSudo = findViewById(R.id.action_undo);
        actionRedo = findViewById(R.id.action_redo);
        actionBold = findViewById(R.id.action_bold);
        actionItalic = findViewById(R.id.action_italic);
        actionStrikeThrough = findViewById(R.id.action_strikethrough);
        actionUnderLine = findViewById(R.id.action_underline);
        actionHead1 = findViewById(R.id.action_heading1);
        actionHead2 = findViewById(R.id.action_heading2);
        actionHead3 = findViewById(R.id.action_heading3);
        actionHead4 = findViewById(R.id.action_heading4);
        actionHead5 = findViewById(R.id.action_heading5);
        actionHead6 = findViewById(R.id.action_heading6);
        actionNumber = findViewById(R.id.action_insert_numbers);
        actionImage = findViewById(R.id.action_insert_image);
        actionVideo = findViewById(R.id.action_insert_video);
        richEditor = findViewById(R.id.irich_editor);
    }

    private void initAttrs(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IRichEditor);

        textBackgroundColor = ta.getColor(R.styleable.IRichEditor_textBackgroundColor,
                ContextCompat.getColor(context, R.color.white));
        defTextColor = ta.getColor(R.styleable.IRichEditor_textColor,
                ContextCompat.getColor(context, R.color.white));
        hintText = ta.getString(R.styleable.IRichEditor_hintText);
        defTextSize = ta.getDimension(R.styleable.IRichEditor_textSize, 16f);

        ta.recycle();
        showView();
        Log.e(TAG, "defTextSize = " + defTextSize + " , textColor = " + defTextColor);
        Log.e(TAG, "hintText = " + hintText + " , textBackgroundColor = " + textBackgroundColor);
    }

    private void showView() {
        richEditor.setTextBackgroundColor(defTextColor);
        richEditor.setPlaceholder(hintText);
        richEditor.setTextColor(defTextColor);
        richEditor.setFontSize(Math.round(defTextSize));
        richEditor.setTextBackgroundColor(defTextColor);
    }

}
