package com.open.levelcrossapp

import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.open.levelcrossapp.ui.compose.HomeScreen
import com.open.levelcrossapp.ui.theme.LevelCrossAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()

        }
    }
}
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.poda)
        val webView: WebView = findViewById(R.id.kkop)
//        webView.settings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
        webView.settings.javaScriptEnabled = true
        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        WebView.setWebContentsDebuggingEnabled(true)
        // Handle redirections and page loading within WebView
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
               Log.d("tada",request.url.toString())
                view.loadUrl(request.url.toString())
                return true // Don't let the system handle the URL
            }

            // Handle any error cases here (optional)
        }
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                // Ignore SSL certificate errors
                handler.proceed()
            }
        }
       */
/* webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("tadada","url"+url)
                getMusicHomeHtmlContent(view!!)
//                            CoroutineScope(Dispatchers.IO).launch {
//                            if (type == YoutubeScrapType.YOUTUBE_MUSIC) {
//                                getMusicHomeHtmlContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_PLAYLIST) {
//                                getMusicPlayListHtmlContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_HOME) {
//                                getYoutubeContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_MUSIC_CATEGORY) {
//                                getMusicCategoryHtmlContent(webView)
//                            }
//                            }
            }
        }*//*

        webView.loadUrl("https://etrain.info/trains/Ernakulam-Jn-ERS-to-Kottayam-KTYM")
       */
/* CoroutineScope(Dispatchers.IO).launch {
            try {
                withContext(Dispatchers.Main) {
                    webView.settings.javaScriptEnabled = true

                    webView.webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
//                            CoroutineScope(Dispatchers.IO).launch {
//                            if (type == YoutubeScrapType.YOUTUBE_MUSIC) {
//                                getMusicHomeHtmlContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_PLAYLIST) {
//                                getMusicPlayListHtmlContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_HOME) {
//                                getYoutubeContent(webView)
//                            } else if (type == YoutubeScrapType.YOUTUBE_MUSIC_CATEGORY) {
//                                getMusicCategoryHtmlContent(webView)
//                            }
//                            }
                        }
                    }
                    webView.loadUrl("https://www.railyatri.in/booking/trains-between-stations?device_type_id=6&from_code=KTYM&from_name=KOTTAYAM+&journey_date=05-09-2024&src=tbs&to_code=ERS&to_name=ERNAKULAM+JN+&user_id=-1720504112&user_token=61720504112&utm_source=tt_dwebhome_search")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }*//*


        lifecycleScope.launch {
            main()
        }
    }
    suspend fun main() {

        //https://www.confirmtkt.com/train-running-status/22113?Date=07-Sep-2024
        withContext(Dispatchers.IO)
        {
            val html = """
        <div class="trainlist rnd5">
            <table>
                <tbody>
                    <tr data-train='{"typ":"exp","num":"16350","name":"RAJYA RANI EXP","s":"ERN","st":"01:15","d":"KTYM","dt":"02:20","tt":"01:05H","dy":"1111111","book":"1","arp":120}'></tr>
                    <tr data-train='{"typ":"pass","num":"12345","name":"SUPER FAST","s":"DEL","st":"10:00","d":"MUM","dt":"20:00","tt":"10:00H","dy":"0111100","book":"2","arp":150}'></tr>
                </tbody>
            </table>
        </div>
    """

            // Parse the HTML
            val document: Document =
                Jsoup.connect("https://etrain.info/trains/Ernakulam-Jn-ERS-to-Kottayam-KTYM").get()

            // Select all <tr> elements
            val trElements: Elements = document.select("tr")

            for (trElement: Element in trElements) {
                // Get the data-train attribute
                val dataTrain: String = trElement.attr("data-train")

                // Parse JSON data
                try {
                    val jsonObject = JSONObject(dataTrain)
                    println("Train Type: ${jsonObject.getString("typ")}")
                    println("Train Number: ${jsonObject.getString("num")}")
                    println("Train Name: ${jsonObject.getString("name")}")
                    println("Source Station: ${jsonObject.getString("s")}")
                    println("Departure Time: ${jsonObject.getString("st")}")
                    println("Destination Station: ${jsonObject.getString("d")}")
                    println("Arrival Time: ${jsonObject.getString("dt")}")
                    println("Total Time: ${jsonObject.getString("tt")}")
                    println("Days of Operation: ${jsonObject.getString("dy")}")
                    println("Booking Status: ${jsonObject.getString("book")}")
                    println("Arp: ${jsonObject.getInt("arp")}")
                    println()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun getMusicHomeHtmlContent(webView: WebView) {
//        if (!alreadyEvaluated) {
//            alreadyEvaluated = true
            webView.evaluateJavascript("(function() { return document.documentElement.outerHTML; })();") { html ->
                val cleanHtml = html.replace("\\u003C", "<").replace("\\u003E", ">")
                Log.d("kkoa",cleanHtml)
//                var result = decodeHexString(
//                    extractDataBetween(
//                        cleanHtml,
//                        "initialData.push({path: '\\\\/browse', params",
//                        "'});ytcfg.set"
//                    ) + ""
//                )
//                result = getDataSubstring(result)
//                result = result.replace("\\\\\\\\\"", "")
//                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                val clip = ClipData.newPlainText("label", result)
//                clipboard.setPrimaryClip(clip)
////                getDataSubstring
//                result = result.replaceFirst("= '{", "{").replaceFirst("';", "")
//                    .replace("\\\\\\\\\"", "")
////                webViewModel.setHtmlContent(result)
//                CoroutineScope(Dispatchers.IO).launch {
//                    Log.d("passing home data", "yaaa1111")
//                    if (result.startsWith("{")&&result.endsWith("}")) {
//
////                        passYtMusicHomeData(parseJson(result))
//                    }
//
//                }
            }
//        } else {
////            alreadyEvaluated = false
//        }

    }

    suspend fun runtheapp() {
        withContext(Dispatchers.IO) {
            try {
                // Replace this with the actual URL you want to scrape
                val url = "https://www.railyatri.in/booking/trains-between-stations?device_type_id=6&from_code=KTYM&from_name=KOTTAYAM+&journey_date=05-09-2024&src=tbs&to_code=ERS&to_name=ERNAKULAM+JN+&user_id=-1720504112&user_token=61720504112&utm_source=tt_dwebhome_search"
                val doc = Jsoup.connect(url).get()

                // Select all <a> tags that contain 'MuiTypography-root' and 'MuiLink-root' in their class attribute
                val links: Elements =
                    doc.select("a[class*='MuiTypography-root'][class*='MuiLink-root']")
Log.d("TADA","NANANANANAN")
                // Iterate through the elements and extract data
                for (link: Element in links) {
                    val href: String = link.attr("href")
                    val spanText: String = link.select("span").text()
                    val remainingText: String = link.ownText().trim()

                    println("Href: $href")
                    println("Span Text: $spanText")
                    println("Remaining Text: $remainingText")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LevelCrossAppTheme {
        Greeting("Android")
    }
}