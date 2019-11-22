package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.ChildrenDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.NameDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/abc")
public class NotificationController {

//    const TREE_DATA: FoodNode[] = [
//    {
//        name: 'Fruit',
//                children: [
//        {name: 'Apple'},
//        {name: 'Banana'},
//        {name: 'Fruit loops'},
//    ]
//    }, {
//        name: 'Vegetables',
//                children: [
//        {
//            name: 'Green',
//                    children: [
//            {name: 'Broccoli'},
//            {name: 'Brussel sprouts'},
//        ]
//        }, {
//            name: 'Orange',
//                    children: [
//            {name: 'Pumpkins'},
//            {name: 'Carrots'},
//        ]
//        },
//    ]
//    },
//            ];


    @GetMapping("/test")
    public NameDTO test(){
        NameDTO nameDTO = new NameDTO();
        nameDTO.setName("Amesh");

        List<NameDTO> nameDTOS = new ArrayList<>();

        NameDTO a = new NameDTO("ASD");
        NameDTO b = new NameDTO("ASDNDNDN");
        NameDTO c = new NameDTO("ASDNDND");
        NameDTO d = new NameDTO("ASDDDM");

        nameDTOS.add(a);
        nameDTOS.add(b);
        nameDTOS.add(c);
        nameDTOS.add(d);


        nameDTO.setChildren(nameDTOS);
        return nameDTO;
    }

}
