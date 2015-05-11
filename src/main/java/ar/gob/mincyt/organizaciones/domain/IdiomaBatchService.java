package ar.gob.mincyt.organizaciones.domain;
import org.gvnix.addon.jpa.addon.batch.GvNIXJpaBatch;
import org.springframework.stereotype.Service;

@Service
@GvNIXJpaBatch(entity = Idioma.class)
public class IdiomaBatchService {
}
