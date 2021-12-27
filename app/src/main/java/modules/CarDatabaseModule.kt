import android.app.Application
import androidx.room.Room
import com.example.kolesaparser.repository.CarDao
import com.example.kolesaparser.repository.CarRoomDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val carDatabaseModule = module {

    fun provideDatabase(application: Application): CarRoomDatabase {
        return Room.databaseBuilder(
            application,
            CarRoomDatabase::class.java,
            "car_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(database: CarRoomDatabase): CarDao {
        return database.carDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}