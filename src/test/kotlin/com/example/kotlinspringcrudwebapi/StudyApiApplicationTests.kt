package com.example.kotlinspringcrudwebapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import kotlin.math.log

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KotlinSpringCrudWebApiApplicationTests(@Autowired val mockMvc: MockMvc) {
    @Test
    @DisplayName("get /customers のテスト")
    fun RESTAPIの動作確認() {
        /**
         * given:
         * - 引数はなし
         */

        /**
         * when:
         * - get /customers を実行
         * - レスポンスステータスとレスポンスボディを取得
         */
        val response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        // エンドポイントを叩いた後、HTTPステータスとBodyの中身を取得
        val actualStatus = response.status
        val actualResponseBody = response.contentAsString


        /**
         * then:
         * - ステータスコードが一致する
         * - レスポンスボディが一致する
         */
        // 期待値の設定
        val expectedStatus = HttpStatus.OK.value()
        val expectedResponseBody =
                """
               {
                 "customers": [
                   {
                     "id": 1,
                     "firstName": "Alice",
                     "lastName": "Sample1"
                   },
                   {
                     "id": 2,
                     "firstName": "Bob",
                     "lastName": "Sample2"
                   }
                 ]
               }
            """.trimIndent()

        // ステータスコードが一致する
        assertThat(actualStatus).isEqualTo(expectedStatus)

        // Bodyの中身が一致する
        JSONAssert.assertEquals(
                expectedResponseBody,
                actualResponseBody,
                JSONCompareMode.NON_EXTENSIBLE
        )
    }
}
