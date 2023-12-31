package com.example.mydailyjournal.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mydailyjournal.Constants
import com.example.mydailyjournal.QuestionSet
import com.example.mydailyjournal.R

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<QuestionSet>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mTopic : String? = null

    private var progressBar: ProgressBar?= null
    private var tvProgress: TextView?= null
    private var tvQuestion: TextView?= null
    private var ivImage: ImageView?= null

    private var tvOptionOne: TextView?= null
    private var tvOptionTwo: TextView?= null
    private var tvOptionThree: TextView?= null
    private var tvOptionFour: TextView?= null

    private var btnSubmit: Button?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mTopic = intent.getStringExtra(Constants.TOPIC)     //Topic received from MainActivity

        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress_bar)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.option_one)
        tvOptionTwo = findViewById(R.id.option_two)
        tvOptionThree = findViewById(R.id.option_three)
        tvOptionFour = findViewById(R.id.option_four)

        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionList = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion() {

        defaultOptionView()         //to reset chosen option feature every time we go to the next question

        val question: QuestionSet = mQuestionList!![mCurrentPosition - 1]

        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


            btnSubmit?.text = "SUBMIT"

    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)     //we are adding the option to the array list declared above
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        //setting the view of all the options in the ArrayList to default option view
        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }


    //to change the interface as we select an option
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){

        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)



    }

    override fun onClick(view: View?) {
        when(view?.id) {                //when selected option is option 1, we pass the text view and the option number to the selectedOptionView function
            R.id.option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.option_four ->
            {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit ->{

                when
                {
                    mCurrentPosition <= mQuestionList!!.size ->     //as long as we have questions left
                    {
                        setQuestion()
                    }
                }

                optionView(mSelectedOptionPosition, R.drawable.chosen_option_border)
                btnSubmit?.text = "GO TO NEXT QUESTION"

                if (mCurrentPosition == mQuestionList!!.size){   //once we have reached the end of question list, we move to Gratitude Activity
                    btnSubmit?.setOnClickListener{
                        val intent = Intent(this, GratitudeActivity::class.java)
                        intent.putExtra(Constants.TOPIC, mTopic)
                        startActivity(intent)
                        finish()
                    }
                }

            }
        }
    }

    //to change the interface after clicking submit
    private fun optionView(answer: Int, drawableView: Int)
    {
        when(answer){

            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }


        }
    }
}