package com.platina125.projectmobile

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.platina125.projectmobile.databinding.ActivityHome1Binding
import java.io.File

class Home1 : AppCompatActivity() {
    val binding by lazy{ActivityHome1Binding.inflate(layoutInflater)}

    var photoUri: Uri? = null

    lateinit var cameraPermission: ActivityResultLauncher<String>
    lateinit var storagePermission: ActivityResultLauncher<String>

    lateinit var cameraLauncher: ActivityResultLauncher<Uri>
    lateinit var galleryLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentMusic = Intent(this, MusicActivity::class.java)
        binding.MusicBtn.setOnClickListener{startActivity(intentMusic)}

        val intentTimer = Intent(this, Timer::class.java)
        binding.TimerBtn.setOnClickListener{startActivity(intentTimer)}
        binding.TimerText.setOnClickListener{startActivity(intentTimer)}

        val intentCalendar = Intent(this, Calendar::class.java)
        binding.CalendarBtn.setOnClickListener{startActivity(intentCalendar)}
        binding.CalendarText.setOnClickListener{startActivity(intentCalendar)}

        val intentMemo = Intent(this, NoteMemo::class.java)
        binding.MemoBtn.setOnClickListener{startActivity(intentMemo)}
        binding.MemoText.setOnClickListener{startActivity(intentMemo)}

        val intentShopping = Intent(this, Shopping::class.java)
        binding.ShoppingBtn.setOnClickListener{startActivity(intentShopping)}
        binding.ShoppingText.setOnClickListener{startActivity(intentShopping)}

        val intentCommunity = Intent(this, Home2::class.java)
        binding.CommunityBtn.setOnClickListener{startActivity(intentCommunity)}
        val intentMap = Intent(this, Home3::class.java)
        binding.MapBtn.setOnClickListener{startActivity(intentMap)}
        val intentGallery = Intent(this, Home4::class.java)
        binding.GalleryBtn.setOnClickListener{startActivity(intentGallery)}
        val intentMyPage = Intent(this, Home5::class.java)
        binding.MyPageBtn.setOnClickListener{startActivity(intentMyPage)}

        storagePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if(isGranted) {
                setViews()
            } else {
                Toast.makeText(baseContext, "외부저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        cameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if(isGranted) {
                openCamera()
            } else {
                Toast.makeText(baseContext, "카메라 권한을 승인해야 카메라를 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
            }
        }

        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess  ->
            if(isSuccess) { binding.imagePreview.setImageURI(photoUri) }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding.imagePreview.setImageURI(uri)
        }

        storagePermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    fun setViews() {
        binding.buttonCamera.setOnClickListener {
            cameraPermission.launch(Manifest.permission.CAMERA)
        }
        binding.buttonGallery.setOnClickListener {
            openGallery()
        }
    }

    fun openCamera() {
        val photoFile = File.createTempFile(
            "IMG_",
            ".jpg",
            getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        )

        photoUri = FileProvider.getUriForFile(
            this,
            "${packageName}.provider",
            photoFile
        )

        cameraLauncher.launch(photoUri)
    }

    fun openGallery() {
        galleryLauncher.launch("image/*")
    }
}