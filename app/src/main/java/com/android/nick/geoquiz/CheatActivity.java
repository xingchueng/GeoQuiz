package com.android.nick.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Nick on 29/6/15.
 */
public class CheatActivity extends Activity {

	public static final String EXTRA_ANSWER_IS_TRUE = "com.android.nick.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN  = "com.android.nick.answer_shown";
	private boolean mAnswerIsTrue;

	private TextView mAnswerTextView;
	private Button mShowAnswer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

		setAnswerShownResult(false);
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnaswerButton);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue){
					mAnswerTextView.setText(R.string.true_button);
				}else{
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
			}
		});
	}

	private void setAnswerShownResult(boolean isAnswerShown){
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK,data);
	}
}
