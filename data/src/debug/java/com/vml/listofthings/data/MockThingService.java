package com.vml.listofthings.data;

import com.vml.listofthings.core.things.ThingEntity;

import rx.Observable;

/**
 * Created by tway on 5/10/16.
 */
public class MockThingService implements ThingService {
    @Override
    public Observable<ThingEntity[]> getThingList() {
        return Observable.fromCallable(this::getMockThingList);
    }

    ThingEntity[] getMockThingList() {
        int total = 300;
        ThingEntity[] things = new ThingEntity[total];
        for (int i = 0; i < total; i++) {
            things[i] = ThingEntity.create("" + i, "title " + i, "summary " + i);
        }
        return things;
    }
}