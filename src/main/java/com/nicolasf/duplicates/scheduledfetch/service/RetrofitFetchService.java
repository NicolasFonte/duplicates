package com.nicolasf.duplicates.scheduledfetch.service;

import com.nicolasf.duplicates.cache.DuplicatesCache;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

/**
 * Directly API Rest caller. No need to test for this exercise.
 * For production code consider Make 'Cache' a Component and
 * make OkHttpClient external dependency.
 */
@Service
public class RetrofitFetchService implements FetchService {

    private static final String URL = "http://challenge.carjump.net/A";

    @Override
    public void fetchEntries() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL)
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody body = response.body();
        if (body == null) {
            throw new IOException("Response from API is empty!");
        }
        String[] entries = body.string().split(System.lineSeparator());
        DuplicatesCache.addFreshEntries(Arrays.asList(entries));
    }
}
