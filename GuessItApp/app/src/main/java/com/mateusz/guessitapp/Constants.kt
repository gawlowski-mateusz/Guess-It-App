package com.mateusz.guessitapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val PLAY_MODE : String = "play_mode"
    const val TOTAL_QUESTIONS : String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_TIME : String = "quiz_time"

    //////////  PLAYERS QUESTIONS  //////////

    fun getPlayersQuestions():ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_dybala,
            "Messi",
            "Dybala",
            "Ronaldo",
            "Haaland",
            2
            )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_ronaldo,
            "Lewandowski",
            "Neymar",
            "Suarez",
            "Ronaldo",
            4
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_modric,
            "Iniesta",
            "Casemiro",
            "Modric",
            "Ederson",
            3
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_messi,
            "Messi",
            "Di Maria",
            "Suarez",
            "Guardiol",
            1
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_kane,
            "Reus",
            "Kane",
            "Jota",
            "Rodrygo",
            2
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_neuer,
            "Ederson",
            "Neuer",
            "Van Der Saar",
            "Ter Stegen",
            2
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_neymar,
            "Ronaldinho",
            "Rahpinia",
            "Suarez",
            "Neymar",
            4
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_van_dijk,
            "Van Dijk",
            "Boateng",
            "Kross",
            "Kimmich",
            1
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_lewandowski,
            "Griezmann",
            "Giroud",
            "Lewandowski",
            "Dumfries",
            3
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "GUESS THE FOOTBALL PLAYER",
            R.drawable.ic_marchisio,
            "Pjanic",
            "Marchisio",
            "Goretzka",
            "Balde",
            2
        )
        questionsList.add(question10)

        return questionsList
    }

    //////////  CLUBS LOGOS QUESTIONS  //////////

    fun getClubsLogosQuestions():ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_real_madrid,
            "FC Barcelona",
            "Paris Saint Germain",
            "Real Madrid",
            "Arsenal",
            3
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_bayern_munchen,
            "Bayern Munchen",
            "Atletico Madrid",
            "Manchester United",
            "Sevilla",
            1
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_paris_saint_germain,
            "Paris Saint Germain",
            "Borussia Dortmund",
            "Manchester City",
            "Manchester United",
            1
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_juventus,
            "Schalke",
            "Spurs",
            "Juventus",
            "Napoli",
            3
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_as_roma,
            "AC milan",
            "AS Roma",
            "Leeds",
            "Young Boys",
            2
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_atletico_madrid,
            "Bayer Leverkusen",
            "Inter Mediolan",
            "Wolfsburg",
            "Atletico Madrid",
            4
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_marseille,
            "Marseille",
            "Inter Miami",
            "Manchester City",
            "Napoli",
            1
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_slask_wroclaw,
            "Lech Poznan",
            "Slask Wroclaw",
            "Arka Gdynia",
            "Cracovia",
            2
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_sc_freiburg,
            "SC Freiburg",
            "Schalke",
            "Boca Juniors",
            "Lecce FC",
            1
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "GUESS THE FOOTBALL CLUB NAME",
            R.drawable.ic_norwich_city,
            "SV Werder Bremen",
            "Manchester United",
            "Norwich City",
            "RCD Mallorca",
            3
        )
        questionsList.add(question10)

        return questionsList
    }

    //////////  STADIUM QUESTIONS  //////////

    fun getStadiumsQuestions():ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_allianz_arena,
            "Allianz Arena",
            "Wembley",
            "Parc Des Princes",
            "Camp Nou",
            1
        )
        questionsList.add(question1)


        val question2 = Question(
            2,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_michigan_stadium,
            "Wembley",
            "Michigan Stadium",
            "Old Trafford",
            "AT&T Stadium",
            2
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_san_siro,
            "San Siro",
            "Estadio Santiago Bernabeu",
            "Melbourne Cricket Ground",
            "Parc Des Princes",
            1
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_camp_nou,
            "Old Trafford",
            "Ohio Stadium",
            "Camp Nou",
            "Signal Induna Park",
            3
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_stade_de_france,
            "Salt Lake Stadium",
            "FNB STADIUM",
            "Stade De France",
            "Rose Bowl",
            3
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_luzhniki_stadium,
            "Beaver Stadium",
            "Luzhniki Stadium",
            "Parc Des Princes",
            "Tiger Stadium",
            2
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_parc_des_princes,
            "Kyle Field",
            "Salt Lake Stadium",
            "Parc Des Princes",
            "MetLife Stadium",
            3
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_de_meer_stadion,
            "Azadi Stadium",
            "Estadio Da Luz",
            "Ibrox Stadium",
            "De Meer Stadion",
            4
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_juventus_stadium,
            "Juventus Stadium",
            "Celtic Park",
            "Estadio Centenario",
            "Anfield",
            1
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "GUESS THE STADIUM NAME",
            R.drawable.ic_estadio_azteca,
            "Stadio Giuseppe Meazza",
            "Estadio Azteca",
            "The Maracana",
            "Old Trafford",
            2
        )
        questionsList.add(question10)


        return questionsList
    }
}