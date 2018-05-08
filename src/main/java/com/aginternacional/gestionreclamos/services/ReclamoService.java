package com.aginternacional.gestionreclamos.services;

import com.aginternacional.gestionreclamos.domain.Reclamo;
import com.aginternacional.gestionreclamos.repository.ReclamoRepository;
import com.aginternacional.gestionreclamos.services.dto.ReclamoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    public ReclamoService(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public List<Reclamo> obtenerReclamos() {

        List<Reclamo> reclamos = new ArrayList<>();
        reclamoRepository.findAll()
                .forEach(reclamos::add);

        return reclamos;
    }

    public ReclamoDTO insertarReclamoDt(ReclamoDTO reclamoDTO){
        Reclamo reclamo = null;

        BeanUtils.copyProperties(reclamoDTO, reclamo);
        reclamoRepository.save(reclamo);
        reclamoDTO.setId(reclamo.getId());

        return reclamoDTO;
    }
}
