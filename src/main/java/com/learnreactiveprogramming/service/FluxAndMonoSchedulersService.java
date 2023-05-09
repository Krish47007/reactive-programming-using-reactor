package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.learnreactiveprogramming.util.CommonUtil.delay;

public class FluxAndMonoSchedulersService {

    static List<String> namesList = List.of("alex", "ben", "chloe");
    static List<String> namesList1 = List.of("adam", "jill", "jack");

    private String upperCase(String name) {
        delay(1000);
        return name.toUpperCase();
    }

    public Flux<String> namesFlux()
    {
        /*
        * This function takes a collection and creates a Flux out of it.
        * In reality it could be the result of DB call or a remote service call
        */
        return Flux.fromIterable(List.of("Krish","Kirk","Picard")).log();
    }

    public Mono<String> nameMono()
    {
        return Mono.just("Krish");
    }

    public static void main(String[] args) {

        var fluxAndMonoSchedulersService = new FluxAndMonoSchedulersService();

        //To consume data from Flux we need to subscribe it
        //This subscribe() takes a Consumer
        fluxAndMonoSchedulersService.namesFlux()
                .subscribe(name ->{
                    System.out.println("Name is "+name);
                });

       /* System.out.println("--------------------------------");

        //To consume data from Flux we need to subscribe it
        fluxAndMonoSchedulersService.nameMono()
                .subscribe(System.out::println);*/

    }

}
