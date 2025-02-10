package org.example.trouble.demo;


import lombok.extern.slf4j.Slf4j;
import org.example.trouble.demo.Entities.ib.EmpIBEntity;
import org.example.trouble.demo.Repository.db1.db1Repository;
//import org.example.trouble.demo.Repository.db2.db2Repository;
import org.example.trouble.demo.Repository.ib.EmpIBRepository;
import org.example.trouble.demo.gateways.TaiwanDollarGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CoreDemo {

    @Autowired
    private TaiwanDollarGateway taiwanDollarGateway;

    @Autowired
    private db1Repository repository1;
    @Autowired
    private EmpIBRepository empIBRepository;
//    @Autowired
//    private db2Repository repository2;

    public String getMessage()  {
//        try {
//            TW8310803Request request = TW8310803Request.builder().build();
//            taiwanDollarGateway.TW8310803(request).execute().body();
//        }catch(Exception e){
//
//        }
        String db1name=repository1.findById(1).getName();
//        String db2name=repository2.findById(1).getName();
        EmpIBEntity entity= empIBRepository.findByEmpUid("1").stream().findFirst().orElse(null);


        log.info("entity:"+entity);
return String.format("db1:%s",db1name);

//        return "Hello world";
//        return messageDemo.message();

    }




}
