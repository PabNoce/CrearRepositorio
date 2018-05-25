/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miorg.crearrepositorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.miorg.crearrepositorio.CreateRep"
)
@ActionRegistration(
        iconBase = "org/miorg/crearrepositorio/descarga.png",
        displayName = "#CTL_CreateRep"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0)
    ,
  @ActionReference(path = "Toolbars/Build", position = 500)
})
@Messages("CTL_CreateRep=Crear Repositorio")
public final class CreateRep implements ActionListener {

    static GitHub github;

    @Override
    public void actionPerformed(ActionEvent e) {
        //Solicitamos el nombre del repositorio a crear
        String repoNombre = JOptionPane.showInputDialog("Introduce nombre del repositorio");
        try {
            //Generamos el constructor
            GHCreateRepositoryBuilder repo;
            repo = github.createRepository(repoNombre);
            //Creamos el repositorio remoto con el nombre indicado
            repo.autoInit(true).create();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        //informamos al usuario de que todo ha ido bien
        System.out.println("Listo");
    }
}
