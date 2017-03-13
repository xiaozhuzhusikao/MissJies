package com.m520it.missjie.shop.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.m520it.missjie.R;

public class NumberInputView extends LinearLayout implements OnClickListener{
	
	private ImageView mIncreaseIv;
	private EditText mNumberTv;
	private ImageView mDecreaseIv;
	private int mMax;
	private int mCurrentNum;
	private INumberInputListener mListener;
	
	public void setListener(INumberInputListener mListener) {
		this.mListener = mListener;
	}

	public NumberInputView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
	 *	传入库存 方便在输入代码/点击加减的时候对输入框的内容进行大小控制
	 */
	public void setMax(int mMax) {
		this.mMax = mMax;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mIncreaseIv=(ImageView) findViewById(R.id.increase_count);
		mDecreaseIv=(ImageView) findViewById(R.id.decrease_count);
		mIncreaseIv.setOnClickListener(this);
		mDecreaseIv.setOnClickListener(this);
		mNumberTv=(EditText) findViewById(R.id.number_et);
		mNumberTv.addTextChangedListener(new TextChangedListener());
	}
	
	public boolean ifChanged=true;
	public class TextChangedListener implements TextWatcher{
		
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			if (!ifChanged) {
				return;
			}
			checkNumber();
		}
		
	}

	private void checkNumber() {
		ifChanged=false;
		String number = mNumberTv.getText().toString();
		if (!TextUtils.isEmpty(number)) {
			mCurrentNum=Integer.parseInt(number);
			if (mCurrentNum<1) {
				mCurrentNum=1;
				mNumberTv.setText(mCurrentNum+"");
			}
			if (mCurrentNum>mMax) {
				mCurrentNum=mMax;
				mNumberTv.setText(mCurrentNum+"");
			}
		}else {
			mNumberTv.setText("1");
		}
		if (mListener!=null) {
			mListener.onTextChange(Integer.parseInt(mNumberTv.getText().toString()));
		}
		ifChanged=true;
	}

	@Override
	public void onClick(View v) {
		String number = mNumberTv.getText().toString();
		if (TextUtils.isEmpty(number)) {
			mNumberTv.setText("0");
			return;
		}
		mCurrentNum=Integer.parseInt(number);
		if (v.getId()==R.id.increase_count) {
			mCurrentNum++;
		}else if (v.getId()==R.id.decrease_count) {
			mCurrentNum--;
		}
		mNumberTv.setText(mCurrentNum+"");
	}

}
