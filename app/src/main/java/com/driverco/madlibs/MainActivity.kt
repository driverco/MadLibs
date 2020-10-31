package com.driverco.madlibs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {


    var rand: Random? = null
    var storyNum = 0
    var indexOfType: Int = 0
    var madWords: ArrayList<String>? = null
    var words = arrayOf(
        arrayOf("<job>", "<adjective>"),
        arrayOf(
            "<adjective",
            "plural-noun",
            "noun",
            "adjective",
            "place",
            "plural-noun",
            "noun",
            "funny-noise",
            "adjective",
            "noun",
            "adjective",
            "plural-noun",
            "<person's-name>"
        ),
        arrayOf(
            "<adjective>",
            "<plural-noun>",
            "<plural-noun>",
            "<plural-noun>",
            "<adjective>",
            "<adjective>",
            "<plural-noun>",
            "<number>",
            "<noun>",
            "<plural-noun>",
            "<adjective>",
            "<job-title>",
            "<job-title>",
            "<noun>",
            "<plural-noun>",
            "<adjective>"
        ),
        arrayOf(
            "<Male-Name>",
            "<adjective>",
            "<CITY>",
            "<adjective>",
            "<unusual-adjective>",
            "<plural-noun>",
            "<plural-noun>",
            "<plural-noun>",
            "<plural-noun>",
            "<Color!>",
            "<adjective>",
            "<Exciting-adjective>",
            "<plural-noun>",
            "<Interesting-Adjective>"
        ),
        arrayOf(
            "<aDvErB>",
            "<NUMBER>",
            "<Plural-Noun>",
            "<verb>",
            "<body-part>",
            "<verb>",
            "<adverb>",
            "<pluRAL-nOUN>",
            "<plural-noun>",
            "<plural-noun>",
            "<FUNNY-noise>",
            "<verb>",
            "<Number>",
            "<verB>"
        )
    )
    var arr = arrayOf(
        "I wannabe a <job> when I grow up.\n" +
                "Just like my dad.\n" +
                "Life is <adjective> like that!",
        ("One of the most <adjective> characters in fiction is named\n" +
                "\"Tarzan of the <plural-noun> .\" Tarzan was raised by a/an\n" +
                "<noun> and lives in the <adjective> jungle in the\n" +
                "heart of darkest <place> . He spends most of his time\n" +
                "eating <plural-noun> and swinging from tree to <noun> .\n" +
                "Whenever he gets angry, he beats on his chest and says,\n" +
                "\" <funny-noise> !\" This is his war cry. Tarzan always dresses in\n" +
                "<adjective> shorts made from the skin of a/an <noun>\n" +
                "and his best friend is a/an <adjective> chimpanzee named\n" +
                "Cheetah. He is supposed to be able to speak to elephants and\n" +
                "<plural-noun> . In the movies, Tarzan is played by <person's-name> ."),
        ("Our American universities offer students many <adjective>\n" +
                "courses that will prepare them to become professional <plural-noun> .\n" +
                "You can get a degree as a Bachelor of <plural-noun> or take a\n" +
                "regular liberal <plural-noun> course. Or, if you want to become\n" +
                "a/an <adjective> engineer, you can study <adjective> mathematics\n" +
                "and differential <plural-noun> . Then, after <number> years, if\n" +
                "you want to continue your studies you can write a/an <noun> and\n" +
                "become a Doctor of <plural-noun> . \n" +
                "\n" +
                "When you get out into the <adjective> world, if you have a diploma \n" +
                "from a university, you will be able to get a job easily as a/an <job-title> \n" +
                "or even a/an <job-title> . If you don't have a diploma, you may have to take\n" +
                "a job as a <noun> . \n" +
                "\n" +
                "Remember, it's important that you study hard in high school so you are able \n" +
                "to do well on your college entrance <plural-noun> . It is true that \"a little \n" +
                "learning is a/an <adjective> thing.\""),
        ("<Male-Name> has announced that his <adjective>\n" +
                "clothing store in the heart of downtown <CITY> is having\n" +
                "a/an <adjective> sale of all merchandise, including\n" +
                "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
                "available. Men's cable-knit <plural-noun> , only $15.99.\n" +
                "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
                "breasted cashmere <plural-noun> , $50.00. Genuine imported\n" +
                "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
                "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
                "This is a chance to get some really <Interesting-Adjective> bargains."),
        ("Here's how you dance the Monstrosity. Stand with your feet together.\n" +
                "Now, move your left foot <aDvErB> to the side. Now stamp your\n" +
                "right foot <NUMBER> times and put your hands on your partner's\n" +
                "<Plural-Noun> . Next, you both <verb> slowly to the right and bend\n" +
                "your <body-part> backward. For the next eight counts,\n" +
                "both of you <verb> <adverb> to the left. Next, you and\n" +
                "your partner stand back to back and wiggle your <pluRAL-nOUN> and\n" +
                "slap your <plural-noun> together. Don't forget to keep stamping\n" +
                "your right foot. Now, face your partner again, put your <plural-noun>\n" +
                "together and shout, \" <FUNNY-noise> !\" Now, <verb> backward\n" +
                "and repeat the whole thing <Number> times. If you feel that you can't\n" +
                "learn this dance, you can always <verB> the next one out.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rand = Random()
        madWords = ArrayList<String>()
        pickRandomNumber()
        displayInfo()
    }


    private fun pickRandomNumber() {
        storyNum = rand!!.nextInt(arr.size)
        // storyNum=0;
        madWords = ArrayList<String>()
        indexOfType = 0
    }

    private fun displayInfo() {
        val tv1: TextView = findViewById(R.id.wordDetail)
        val tv2: TextView = findViewById(R.id.numWordsLeft)
        tv2.text = Integer.toString(words[storyNum].size - indexOfType - 1) + " mads words left"
        tv1.text = "Enter a " + words[storyNum][indexOfType]
    }

    private fun getRes(): String {
        val res = StringBuilder()
        var i: Int
        var j: Int
        var k = 0
        val arr2 = arr[storyNum].toCharArray()
        i = 0
        while (i < arr[storyNum].length) {
            j = i
            while (j < arr[storyNum].length && arr2[j] != '<') j++
            val sub = arr[storyNum].substring(i, j)
            res.append(sub)
            res.append("<b>")
            while (j < arr[storyNum].length && arr2[j] != '>') j++
            j++
            i = j
            if (k < madWords!!.size) {
                res.append(madWords!![k])
                k++
            }
            res.append("</b>")
        }
        return res.toString()
    }

    fun nextWord(view: View?) {
        val et: EditText = findViewById(R.id.madWord)

        if (et.text.toString().isNotEmpty()) {
            indexOfType++
            val word = et.text.toString()
            et.setText("")
            madWords?.add(word)
            if (indexOfType === words[storyNum].size) {
                val res: String = getRes()
                Log.v("res", "\nfinal result is \n$res")
                val intent = Intent(this, MadStory::class.java)
                intent.putExtra("res", res)
                startActivity(intent)
            } else {
                displayInfo()
            }
        }else{
            Toast.makeText(this, "Text should not be empty", Toast.LENGTH_SHORT).show()
        }
    }
}