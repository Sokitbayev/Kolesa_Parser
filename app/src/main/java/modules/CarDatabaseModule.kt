import android.app.Application
import androidx.room.Room
import com.example.kolesaparser.repository.SearchPropertiesDao
import com.example.kolesaparser.repository.SearchPropertiesRoomDatabase
import com.example.kolesaparser.repository.SearchResultDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val carDatabaseModule = module {

    fun provideDatabase(application: Application): SearchPropertiesRoomDatabase {
        return Room.databaseBuilder(
            application,
            SearchPropertiesRoomDatabase::class.java,
            "search_properties_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideSearchPropertiesDao(database: SearchPropertiesRoomDatabase): SearchPropertiesDao {
        return database.searchPropertiesDao
    }

    fun provideSearchResultDao(database: SearchPropertiesRoomDatabase): SearchResultDao {
        return database.searchResultDao
    }


    single { provideDatabase(androidApplication()) }
    single { provideSearchPropertiesDao(get()) }
    single { provideSearchResultDao(get()) }
}