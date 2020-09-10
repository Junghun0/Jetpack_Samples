package junghoon.jetpack.sample.mask_app_java;

import org.junit.Test;

import java.io.IOException;

import junghoon.jetpack.sample.mask_app_java.model.StoreInfo;
import junghoon.jetpack.sample.mask_app_java.repository.MaskService;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void retrofitTest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MaskService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MaskService service = retrofit.create(MaskService.class);
        StoreInfo storeInfo = service.fetchStoreInfo().execute().body();

        assertEquals(82, storeInfo.getCount());
    }
}