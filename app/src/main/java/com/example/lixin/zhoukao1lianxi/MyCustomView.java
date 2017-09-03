package com.example.lixin.zhoukao1lianxi;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hua on 2017/9/3.
 */

public class MyCustomView extends LinearLayout {


    private Button btn_left;
    private TextView text_center;
    private Button btn_right;
    private int left_btn_text_color;
    private String left_btn_text;
    private float left_btn_size;
    private int left_btn_bg;
    private String center_text1;
    private int center_text_color;
    private float center_text_size;
    private int center_bg;
    private String right_btn_text;
    private int right_btn_text_color;
    private float right_btn_size;
    private int right_btn_bg;

    public MyCustomView(Context context) {
        super(context);
        initView(context,null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        View inflate = inflate(context, R.layout.custom_view, this);
        btn_left = inflate.findViewById(R.id.btn_left);
        text_center = inflate.findViewById(R.id.text_center);
        btn_right = inflate.findViewById(R.id.btn_right);

        if (attrs ==null){
            return;
        }

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener!=null){
                    mOnClickListener.leftonClickListener(view);
                }
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener!=null){
                    mOnClickListener.rightonClickListener(view);
                }
            }
        });


        initAttrs(context,attrs);
        setViewContext();
    }


    private void initAttrs(Context context, AttributeSet attrs) {

        if (attrs == null){
            return;
        }

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);


        left_btn_text = typedArray.getString(R.styleable.MyCustomView_left_btn_text);
        left_btn_text_color = typedArray.getColor(R.styleable.MyCustomView_left_btn_text_color, 0xff0000);
        left_btn_size = typedArray.getDimension(R.styleable.MyCustomView_left_btn_text_size, 18);
        left_btn_bg = typedArray.getColor(R.styleable.MyCustomView_left_btn_bg, 0x00ff00);

        center_text1 = typedArray.getString(R.styleable.MyCustomView_center_text);
        center_text_color = typedArray.getColor(R.styleable.MyCustomView_center_text_color,0xff0000);
        center_text_size = typedArray.getDimension(R.styleable.MyCustomView_center_text_size,18);
        center_bg = typedArray.getColor(R.styleable.MyCustomView_center_text_bg,0x00ff00);

        right_btn_text = typedArray.getString(R.styleable.MyCustomView_right_btn_text);
        right_btn_text_color = typedArray.getColor(R.styleable.MyCustomView_right_btn_text_color,0xff0000);
        right_btn_size = typedArray.getDimension(R.styleable.MyCustomView_right_btn_text_size,18);
        right_btn_bg = typedArray.getColor(R.styleable.MyCustomView_right_btn_bg,0x00ff00);



    }

    private void setViewContext() {

        btn_left.setText(left_btn_text);
        btn_left.setTextColor(left_btn_text_color);
        btn_left.setTextSize(left_btn_size);


        text_center.setText(center_text1);
        text_center.setTextColor(center_text_color);
        text_center.setBackgroundColor(center_bg);
        text_center.setTextSize(center_text_size);


        btn_right.setText(right_btn_text);
        btn_right.setTextColor(right_btn_text_color);
        btn_right.setTextSize(right_btn_size);

    }


    public interface OnClickListener{
        void leftonClickListener(View btn_left);
        void rightonClickListener(View btn_right);
    }

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }


}
