package clinica.service.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clinica.model.Paziente;
import clinica.service.impl.FacadePaziente;

@Component
public class EditorPaziente extends PropertyEditorSupport {
	
	private @Autowired FacadePaziente facadePaziente;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Paziente p = this.facadePaziente.retrievePaziente(Long.valueOf(text));

        this.setValue(p);
    }

}
