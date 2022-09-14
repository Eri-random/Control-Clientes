package mx.com.gm.servicio;

import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private IPersonaDao IPersonaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) IPersonaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        IPersonaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        IPersonaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return IPersonaDao.findById(persona.getId_persona()).orElse(null);
    }
}
