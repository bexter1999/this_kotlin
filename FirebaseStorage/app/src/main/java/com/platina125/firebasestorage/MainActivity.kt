package com.platina125.firebasestorage

import android.Manifest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.platina125.firebasestorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val storage = Firebase.storage("gs://mobile-910c7.appspot.com")
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnUpload.setOnClickListener{
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){ uri->
        // 3. 스토리지 업로드 메소드 호출
        //uploadImage(uri)
        if(uri != null){
            uploadImage(uri)
        }
    }

    val permissionLauncher = registerForActivityResult(ActivityResultContracts.
        RequestPermission()) { isGranted ->
        if(isGranted){
            galleryLauncher.launch("image/*")
        } else {
            Toast.makeText(baseContext,"외부 저장소 읽기 권한을 승인해야 사용할 수 있습니다",
                Toast.LENGTH_LONG).show()
        }
    }


    fun uploadImage (uri: Uri){
        // 1. 경로 + 사용자 ID + 밀리초로 파일 주소 만들기
        val fullPath = makeFilePath("images", "temp", uri)
        // 2. 스토리지에 저장할 경로 설정
        val imageRef = storage.getReference(fullPath)
        // 3. 업로드 태스크 생성
        val uploadTask = imageRef.putFile(uri)
        
        // 4. 업로드 실행 및 결과 확인
        uploadTask.addOnFailureListener{
            Log.d("스토리지","실패 =>${it.message}")
        }.addOnSuccessListener { taskSnapshot ->
            Log.d("스토리지","성공 주소 =>${fullPath}") // 5. 경료를 DB에 저장하고 사용
        }
    }
    
    fun makeFilePath(path:String, userId:String,uri:Uri): String{
        val mimeType = contentResolver.getType(uri)?:"/none" // 마임타입 예) images/jpeg
        val ext = mimeType.split("/")[1]           // 확장자 예) jpeg
        val timeSuffix = System.currentTimeMillis()         // 시간값 예) 12323123123123
        val filename = "${path}/${userId}_${timeSuffix}.${ext}" // 완성
        // 예) 경로/사용자 ID_1231213123123.jpeg
        return filename
    }
}