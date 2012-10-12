/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars() {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("ComponentGroup", com.codename1.ui.ComponentGroup.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("MapComponent", com.codename1.maps.MapComponent.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            return showForm("Main1", null);
        } else {
            Form f = (Form)createContainer(resPath, "Main1");
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("ComponentGroup", com.codename1.ui.ComponentGroup.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("MapComponent", com.codename1.maps.MapComponent.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main1");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Tabs findTabs1(Container root) {
        return (com.codename1.ui.Tabs)findByName("Tabs1", root);
    }

    public com.codename1.ui.Tabs findTabs1() {
        return (com.codename1.ui.Tabs)findByName("Tabs1", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findLogInButtonContainer(Container root) {
        return (com.codename1.ui.Container)findByName("logInButtonContainer", root);
    }

    public com.codename1.ui.Container findLogInButtonContainer() {
        return (com.codename1.ui.Container)findByName("logInButtonContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.TextField findPasswordTextField(Container root) {
        return (com.codename1.ui.TextField)findByName("passwordTextField", root);
    }

    public com.codename1.ui.TextField findPasswordTextField() {
        return (com.codename1.ui.TextField)findByName("passwordTextField", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findPasswordLabel(Container root) {
        return (com.codename1.ui.Label)findByName("passwordLabel", root);
    }

    public com.codename1.ui.Label findPasswordLabel() {
        return (com.codename1.ui.Label)findByName("passwordLabel", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findTeamContainer(Container root) {
        return (com.codename1.ui.Container)findByName("teamContainer", root);
    }

    public com.codename1.ui.Container findTeamContainer() {
        return (com.codename1.ui.Container)findByName("teamContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findScheduleContainer(Container root) {
        return (com.codename1.ui.Container)findByName("scheduleContainer", root);
    }

    public com.codename1.ui.Container findScheduleContainer() {
        return (com.codename1.ui.Container)findByName("scheduleContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Button findButton(Container root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        return (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findLabel1(Container root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        return (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findLabel2(Container root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        return (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findLogInFieldContainer(Container root) {
        return (com.codename1.ui.Container)findByName("logInFieldContainer", root);
    }

    public com.codename1.ui.Container findLogInFieldContainer() {
        return (com.codename1.ui.Container)findByName("logInFieldContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.TextField findUserNameTextField(Container root) {
        return (com.codename1.ui.TextField)findByName("userNameTextField", root);
    }

    public com.codename1.ui.TextField findUserNameTextField() {
        return (com.codename1.ui.TextField)findByName("userNameTextField", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.ComponentGroup findComponentGroup1(Container root) {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup1", root);
    }

    public com.codename1.ui.ComponentGroup findComponentGroup1() {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup1", Display.getInstance().getCurrent());
    }

    public com.codename1.maps.MapComponent findMapComponent(Container root) {
        return (com.codename1.maps.MapComponent)findByName("MapComponent", root);
    }

    public com.codename1.maps.MapComponent findMapComponent() {
        return (com.codename1.maps.MapComponent)findByName("MapComponent", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Form findMain1(Container root) {
        return (com.codename1.ui.Form)findByName("Main1", root);
    }

    public com.codename1.ui.Form findMain1() {
        return (com.codename1.ui.Form)findByName("Main1", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findUserNameLabel(Container root) {
        return (com.codename1.ui.Label)findByName("userNameLabel", root);
    }

    public com.codename1.ui.Label findUserNameLabel() {
        return (com.codename1.ui.Label)findByName("userNameLabel", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findLabel11(Container root) {
        return (com.codename1.ui.Label)findByName("Label11", root);
    }

    public com.codename1.ui.Label findLabel11() {
        return (com.codename1.ui.Label)findByName("Label11", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.ComponentGroup findComponentGroup(Container root) {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup", root);
    }

    public com.codename1.ui.ComponentGroup findComponentGroup() {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findProjectOverviewContainer(Container root) {
        return (com.codename1.ui.Container)findByName("projectOverviewContainer", root);
    }

    public com.codename1.ui.Container findProjectOverviewContainer() {
        return (com.codename1.ui.Container)findByName("projectOverviewContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton", root);
    }

    public com.codename1.components.MultiButton findMultiButton() {
        return (com.codename1.components.MultiButton)findByName("MultiButton", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton2(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton2", root);
    }

    public com.codename1.components.MultiButton findMultiButton2() {
        return (com.codename1.components.MultiButton)findByName("MultiButton2", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton1(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton1", root);
    }

    public com.codename1.components.MultiButton findMultiButton1() {
        return (com.codename1.components.MultiButton)findByName("MultiButton1", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findLogInContainer(Container root) {
        return (com.codename1.ui.Container)findByName("logInContainer", root);
    }

    public com.codename1.ui.Container findLogInContainer() {
        return (com.codename1.ui.Container)findByName("logInContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton5(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton5", root);
    }

    public com.codename1.components.MultiButton findMultiButton5() {
        return (com.codename1.components.MultiButton)findByName("MultiButton5", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Label findLabel(Container root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        return (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton4(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton4", root);
    }

    public com.codename1.components.MultiButton findMultiButton4() {
        return (com.codename1.components.MultiButton)findByName("MultiButton4", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Button findLoginButton(Container root) {
        return (com.codename1.ui.Button)findByName("loginButton", root);
    }

    public com.codename1.ui.Button findLoginButton() {
        return (com.codename1.ui.Button)findByName("loginButton", Display.getInstance().getCurrent());
    }

    public com.codename1.components.MultiButton findMultiButton3(Container root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton3", root);
    }

    public com.codename1.components.MultiButton findMultiButton3() {
        return (com.codename1.components.MultiButton)findByName("MultiButton3", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.Container findTasksContainer(Container root) {
        return (com.codename1.ui.Container)findByName("tasksContainer", root);
    }

    public com.codename1.ui.Container findTasksContainer() {
        return (com.codename1.ui.Container)findByName("tasksContainer", Display.getInstance().getCurrent());
    }

    public com.codename1.ui.ComponentGroup findComponentGroup2(Container root) {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup2", root);
    }

    public com.codename1.ui.ComponentGroup findComponentGroup2() {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup2", Display.getInstance().getCurrent());
    }

    protected void exitForm(Form f) {
        if("Main1".equals(f.getName())) {
            exitMain1(f);
            return;
        }

    }


    protected void exitMain1(Form f) {
    }

    protected void beforeShow(Form f) {
        if("Main1".equals(f.getName())) {
            beforeMain1(f);
            return;
        }

    }


    protected void beforeMain1(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        if("Main1".equals(c.getName())) {
            beforeContainerMain1(c);
            return;
        }

    }


    protected void beforeContainerMain1(Container c) {
    }

    protected void postShow(Form f) {
        if("Main1".equals(f.getName())) {
            postMain1(f);
            return;
        }

    }


    protected void postMain1(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main1".equals(c.getName())) {
            postContainerMain1(c);
            return;
        }

    }


    protected void postContainerMain1(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main1".equals(rootName)) {
            onCreateMain1();
            return;
        }

    }


    protected void onCreateMain1() {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        if(c.getParent().getLeadParent() != null) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main1")) {
            if("userNameTextField".equals(c.getName())) {
                onMain1_UserNameTextFieldAction(c, event);
                return;
            }
            if("passwordTextField".equals(c.getName())) {
                onMain1_PasswordTextFieldAction(c, event);
                return;
            }
            if("loginButton".equals(c.getName())) {
                onMain1_LoginButtonAction(c, event);
                return;
            }
            if("MultiButton".equals(c.getName())) {
                onMain1_MultiButtonAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onMain1_ButtonAction(c, event);
                return;
            }
            if("MultiButton5".equals(c.getName())) {
                onMain1_MultiButton5Action(c, event);
                return;
            }
            if("MultiButton2".equals(c.getName())) {
                onMain1_MultiButton2Action(c, event);
                return;
            }
            if("MultiButton4".equals(c.getName())) {
                onMain1_MultiButton4Action(c, event);
                return;
            }
            if("MultiButton1".equals(c.getName())) {
                onMain1_MultiButton1Action(c, event);
                return;
            }
            if("MultiButton3".equals(c.getName())) {
                onMain1_MultiButton3Action(c, event);
                return;
            }
        }
    }

      protected void onMain1_UserNameTextFieldAction(Component c, ActionEvent event) {
      }

      protected void onMain1_PasswordTextFieldAction(Component c, ActionEvent event) {
      }

      protected void onMain1_LoginButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain1_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButton5Action(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButton2Action(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButton4Action(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButton1Action(Component c, ActionEvent event) {
      }

      protected void onMain1_MultiButton3Action(Component c, ActionEvent event) {
      }

}
