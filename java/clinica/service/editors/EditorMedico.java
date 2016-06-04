package clinica.service.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.service.impl.FacadeMedico;
import clinica.service.impl.FacadePaziente;
@Component
public class EditorMedico extends PropertyEditorSupport{
	private @Autowired FacadeMedico facadeMedico;
	 @Override
	    public void setAsText(String text) {
	        Medico m = this.facadeMedico.retrieveMedico(Long.valueOf(text));

	        this.setValue(m);
	    }
}
