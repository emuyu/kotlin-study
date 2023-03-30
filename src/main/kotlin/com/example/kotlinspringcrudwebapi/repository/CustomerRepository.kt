package com.example.kotlinspringcrudwebapi.repository

import com.example.kotlinspringcrudwebapi.request.Customer

/**
 * Customerテーブルを操作するメソッドをまとめたインターフェース
 */
interface CustomerRepository {
    /**
     * Customerテーブルにデータを挿入するメソッド
     *
     * @param firstName
     * @param lastName
     */
    fun add(firstName: String, lastName:String)

    /**
     * Customerテーブルから全てのデータを取得するメソッド
     *
     * @return
     */
    fun find(): List<Customer>

    /**
     * Customerテーブルのカラムを更新するメソッド
     *
     * @param id
     * @param firstName
     * @param lastName
     */
    fun update(id: Int, firstName: String, lastName: String)

    /**
     * Customerテーブルのカラムを単一削除するメソッド
     *
     * @param id
     */
    fun delete(id: Int)
}