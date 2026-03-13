package com.example.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Model.TeachersModel
import com.example.learnmate.R
import com.example.learnmate.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: TeachersModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()

    }

    private fun getBundle() {
        item = intent.getParcelableExtra("Object") ?: return

        binding.apply {
            detailTitle.text = item.Name
            detailSpecial.text = item.Special
            detailsStudentdash.text = item.Students
            bio.text = item.Biography
            detailsAddress.text = item.Location
            Experiencedash.text = item.Experience.toString() + "Years"
            ratingDash.text = item.Rating.toString()
            backbtn.setOnClickListener { finish() }

            webpic.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
                Toast.makeText(this@DetailActivity, "Website", Toast.LENGTH_SHORT).show()


            }

            messagepic.setOnClickListener {
                val uri = Uri.parse("smsto:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", "Hello")
                startActivity(intent)

            }

            directionpic.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("${item.Location}"))
                startActivity(intent)

            }

            callpic.setOnClickListener {
                val uri = "tel:" + item.Mobile.trim()
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse(uri))
                startActivity(intent)
            }
            sharepic.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(
                    Intent.EXTRA_TEXT, item.Name + " " + item.Address + " " + item.Mobile
                )
                startActivity(Intent.createChooser(intent, "Choose one"))
            }


        }
    }
}