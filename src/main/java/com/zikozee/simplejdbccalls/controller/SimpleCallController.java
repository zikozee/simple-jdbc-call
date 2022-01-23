package com.zikozee.simplejdbccalls.controller;

import com.zikozee.simplejdbccalls.servz.PageQueryCriteria;
import com.zikozee.simplejdbccalls.servz.RouteCountDTO;
import com.zikozee.simplejdbccalls.servz.SimpleCallsService;
import com.zikozee.simplejdbccalls.servz.TranDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 22 Jan, 2022
 */

@RestController
@RequiredArgsConstructor
public class SimpleCallController {

    private final SimpleCallsService simpleCallsService;


    @GetMapping(path = "fetch-route-count/{charge}")
    public ResponseEntity<RouteCountDTO> fetchRouteCount(@PathVariable(value = "charge")double charge){
        return new ResponseEntity<>(simpleCallsService.routeCountDTO(charge), HttpStatus.OK);
    }

    @GetMapping(path = "fetch-routes/{route1}/{route2}")
    public ResponseEntity<Page<TranDetailsDto>> fetchRouteCount(
            @PathVariable(value = "route1")String route1,
            @PathVariable(value = "route2")String route2,
            final PageQueryCriteria criteria){
        return new ResponseEntity<>(simpleCallsService.fetchRoutesPaged(route1, route2, criteria), HttpStatus.OK);
    }

    @GetMapping(path = "fetch-top-15")
    public ResponseEntity<List<TranDetailsDto>> fetchTop15(){
        return new ResponseEntity<>(simpleCallsService.fetchTop15(), HttpStatus.OK);
    }
}
