package com.herpestes.kotlinretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.herpestes.kotlinretrofit.ui.theme.KotlinRetrofitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    LaunchedEffect(key1 = true){

    }
}
fun tumKisiler(){
    val kisilerDaoInterface = ApiUtils.getKisilerGetInterface()

    kisilerDaoInterface.tumKisiler().enqueue(object: Callback<KisilerCevap>{
        override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
            val liste = response.body().kisiler
            for(k in liste){
                Log.e("Kisi bilgi", "**************")
                Log.e("Kisi id: ", k.kisi_id.toString())
                Log.e("Kisi ad: ", k.kisi_ad)
                Log.e("Kisi tel: ", k.kisi_tel)
            }
        }

        override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {}
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinRetrofitTheme {
        Sayfa()
    }
}