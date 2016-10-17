package ru.hiq.coordinators.dagger.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
