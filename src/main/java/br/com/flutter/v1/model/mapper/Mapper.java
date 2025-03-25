package br.com.flutter.v1.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Component
public abstract class Mapper<K, V> {

    @Autowired
    protected ModelMapper modelMapper;


    @SuppressWarnings("unchecked")
    public V domainToDto(K domain) {
        return (V) modelMapper.map(domain, getGenericClass(1));
    }

    @SuppressWarnings("unchecked")
    public K dtoToDomain(V dto) {
        return (K) modelMapper.map(dto, getGenericClass(0));
    }

    public List<V> domainToDto(List<K> domains) {
        return domains.stream().map(this::domainToDto).toList();
    }

    public List<K> dtoToDomain(List<V> dtos) {
        return dtos.stream().map(this::dtoToDomain).toList();
    }

    private Class<?> getGenericClass(Integer argument) {
        Type genericType = getClass().getGenericSuperclass();
        Type tType = ((ParameterizedType) genericType).getActualTypeArguments()[argument];
        String className = tType.getTypeName();
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
