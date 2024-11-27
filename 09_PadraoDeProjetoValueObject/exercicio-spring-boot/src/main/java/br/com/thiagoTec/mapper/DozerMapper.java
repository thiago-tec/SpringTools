package br.com.thiagoTec.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper { //dozer é responsavel por converter entidades em VO
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	//private static ModelMapper mapper = new ModelMapper;
	
	public static <O,D> D parseObject(O origin, Class<D> destination) { //converter obj simples
		return mapper.map(origin, destination);
	}
	
	
	public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination) { //converter lista
		
		List<D> destinationObjects = new ArrayList<>();
		
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}

	
	
}
