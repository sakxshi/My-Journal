package com.example.mydailyjournal

object Constants {

    const val TOPIC : String = "topic"
    const val GRATITUDE : String = "gratitude"
    const val JOURNAL : String = "journal"

    fun getQuestions(): ArrayList<QuestionSet>{
        val questionList = ArrayList<QuestionSet>()

        val ques1 = QuestionSet(
            1,
        "How are you feeling today?",
            R.drawable.ques1,
            "Very Good",
        "Good",
            "Okay",
            "Awful")


        questionList.add(ques1)

        val ques2 = QuestionSet(
            2,
        "How did you spend most of your time today?",
            R.drawable.ques2,
            "Doing Work",
        "With Loved Ones",
            "Exercise",
            "Me Time")


        questionList.add(ques2)

        val ques3 = QuestionSet(
            3,
        "Did you complete your tasks?",
            R.drawable.ques3,
            "Yes, Sincerely did all of them",
        "Yes, but procrastinated a lot",
            "A couple of them",
            "Couldn't get anything done")


        questionList.add(ques3)


        return questionList
    }

}