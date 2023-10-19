package dev.simpleapp.twitter.security.mapper;

public interface Mapper<D, S> {  //Destination type and source type
    D map(S source);
}
