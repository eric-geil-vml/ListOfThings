package com.vml.listofthings.data;

import com.vml.listofthings.core.things.ThingEntity;
import com.vml.listofthings.data.things.ThingService;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by tway on 5/10/16.
 */
public class MockThingService implements ThingService {
    @Override
    public Observable<ThingEntity[]> getThingList() {
        return Observable
                .fromCallable(this::getMockThingList)
                .delay(2, TimeUnit.SECONDS);
    }

    ThingEntity[] getMockThingList() {
        int total = 300;
        ThingEntity[] things = new ThingEntity[total];
        for (int i = 0; i < total; i++) {
            int j = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
            things[i] = ThingEntity.create("" + j, "Thing " + j, "Details for Thing " + j);
        }
        return things;
    }
}
