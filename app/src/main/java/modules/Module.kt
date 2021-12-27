import com.example.kolesaparser.repository.CarRepository
import com.example.kolesaparser.repository.DefaultCarRepository
import com.example.kolesaparser.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val mainModule = module {

    viewModel { MainViewModel(carDao = get()) }

    /*factory {
        DefaultCarRepository(carDao = get())
    }.bind(CarRepository::class)*/
}