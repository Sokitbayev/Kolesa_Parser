import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    viewModel {
        MainViewModel(
            carDao = get(),
            carSearcher = get()
        )
    }
    factory { CarSearcher() }
    /*factory {
        DefaultCarRepository(carDao = get())
    }.bind(CarRepository::class)*/
}