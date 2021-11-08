import android.content.Context
import androidx.test.core.app.ApplicationProvider

open class BaseTest {
    fun getContext(): Context {
        return ApplicationProvider.getApplicationContext<Context>()
    }

}