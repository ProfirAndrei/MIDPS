<?php

class Bootstrap extends Zend_Application_Bootstrap_Bootstrap
{
    protected function _initView() {
        $this->bootstrap('layout');
        $layout = $this->getResource('layout');
        $view = $layout->getView();
        
        $view->doctype('HTML5');
        
        $view->headTitle('The Best Shop')
             ->setSeparator(' - ');
        
        $view->headMeta()->appendHttpEquiv('Content-Type', 'text/html; charset=UTF-8')
            ->appendName('author', 'Profir Andrei');
    
        $view->headLink()->appendStylesheet('/css/reset.css')
            ->appendStylesheet('/css/style.css');
         
        $view->headLink(array(
            'href'  => 'favicon.png',
            'rel'   => 'icon'
        ));
       
        $view->headScript()->appendFile('/js/modernizr.js')
            ->appendFile('/js/jquery-2.1.1.js')
            ->appendFile('/js/scroll-to-top-button.js');
    }
}

