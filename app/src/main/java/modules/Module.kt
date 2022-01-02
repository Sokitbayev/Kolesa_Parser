import com.example.kolesaparser.domain.CarSearcher
import com.example.kolesaparser.repository.DefaultSearchPropertiesRepository
import com.example.kolesaparser.repository.DefaultSearchResultRepository
import com.example.kolesaparser.repository.SearchPropertiesRepository
import com.example.kolesaparser.repository.SearchResultRepository
import com.example.kolesaparser.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val mainModule = module {

    viewModel {
        MainViewModel(
            searchPropertiesRepository = get(),
            carSearcher = get()
        )
    }
    factory { CarSearcher() }
    factory {
        DefaultSearchPropertiesRepository(searchPropertiesDao = get())
    }.bind(SearchPropertiesRepository::class)
    factory {
        DefaultSearchResultRepository(searchResultDao = get())
    }.bind(SearchResultRepository::class)
}