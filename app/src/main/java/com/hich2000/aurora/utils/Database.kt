package com.hich2000.aurora.utils

import android.app.Application
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.hich2000.aurora.AuroraMusicDb
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor(
    application: Application
) {

    private var _db: AuroraMusicDb
    val db: AuroraMusicDb get() = _db

    init {
        val driver: SqlDriver = AndroidSqliteDriver(
            AuroraMusicDb.Schema,
            application,
            "aurora.db",
            callback = object : AndroidSqliteDriver.Callback(AuroraMusicDb.Schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.setForeignKeyConstraintsEnabled(true)
                }
            })
        _db = AuroraMusicDb(driver)
    }

}