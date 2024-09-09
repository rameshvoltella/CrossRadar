package com.open.levelcrossapp.data.formatter.confirmticket

import android.util.Log
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.dto.TrainInfo
import com.open.levelcrossapp.data.formatter.base.FormattedData
import com.open.levelcrossapp.data.formatter.base.FormattedResult
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfirmTicketDataFormatter @Inject constructor():
    FormattedData<String, FormattedResult<TrainInStation, Exception>>() {

    override suspend fun runFormatting(htmlContent: String): FormattedResult<TrainInStation, Exception> {
        Log.d("papap", "yes3")

        val pattern = Pattern.compile("""data\s*=\s*(\[\{.*?\}\]);""")
        val matcher = pattern.matcher(htmlContent)

        if (matcher.find()) {
            val jsonArrayString = matcher.group(1)
            Log.d("poda", jsonArrayString ?: "No JSON array found")

            // Step 2: Parse the JSON array string into a Kotlin data class list
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory()) // Add this line
                .build()
            val listType = Types.newParameterizedType(List::class.java, TrainInfo::class.java)
            val adapter: JsonAdapter<List<TrainInfo>> = moshi.adapter(listType)

            return try {
                val trainInfoList = jsonArrayString?.let { adapter.fromJson(it) }
                if (trainInfoList != null) {
                    FormattedResult.SUCCESS(TrainInStation(trainInfoList))
                } else {
                    FormattedResult.ERROR(Exception("Failed to parse JSON"))
                }
            } catch (e: Exception) {
                Log.e("FormattingError", "Error parsing JSON: ${e.message}", e)
                FormattedResult.ERROR(e)
            }
        } else {
            return FormattedResult.ERROR(Exception("No matching data found in HTML"))
        }
    }
}
