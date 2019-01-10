package com.interfaceTest.demo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import com.interfaceTest.Data.DataClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
@RunWith(Parameterized.class)
public class DataDriverByYaml {

   @Parameterized.Parameters()

    public static List<DataClass> data() throws IOException {


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<DataClass> data = mapper.readValue(

                new File("ezhixinData/login.yaml"),
                new TypeReference<List<DataClass>>(){}
        );

        return data;
    }

    @Parameterized.Parameter
    public DataClass dataw;

    @Test
    public void demo() {
             assertThat(dataw.getCount(),  equalTo(dataw.getKey()));

    }


}