<?php

class IndexController extends Zend_Controller_Action
{

    public function init()
    {
        /* Initialize action controller here */
    }

    public function indexAction()
    {
        
    }

    public function shopAction()
    {
        // action body
        $productsModel = new Application_Model_DbTable_Products();
        $data = $productsModel->fetchAll()->toArray();
        $this->view->products = $data;
    }

    public function getDataForSliderAction()
    {
        $this->_helper->layout->disableLayout();
        
        $productsModel = new Application_Model_DbTable_Products();
        
        $allData = $productsModel->fetchAll()->toArray();
        
        $jIndexes = array();
        $sIndexes = array();
        $dIndexes = array();
        $shIndexes = array();
        for ($i = 0; $i < count($allData); $i++) {
            if ($allData[$i]['category'] == 'jackets') {
                $jIndexes[] = $i;
            }
            if ($allData[$i]['category'] == 'shirts') {
                $sIndexes[] = $i;
            }
            if ($allData[$i]['category'] == 'dresses') {
                $dIndexes[] = $i;
            }
            if ($allData[$i]['category'] == 'shoes') {
                $shIndexes[] = $i;
            }
        }
        
        $dataFinal = array();
        
        $data = array();
        $index = array_rand($jIndexes, 4);
        foreach ($index as $i) {
            $data[] = $allData[$jIndexes[$i]];
        }
        $dataFinal[] = $data;
        
        $data = array();
        $index = array_rand($sIndexes, 4);
        foreach ($index as $i) {
            $data[] = $allData[$sIndexes[$i]];
        }
        $dataFinal[] = $data;
        
        $data = array();
        $index = array_rand($dIndexes, 4);
        foreach ($index as $i) {
            $data[] = $allData[$dIndexes[$i]];
        }
        $dataFinal[] = $data;
        
        $data = array();
        $index = array_rand($shIndexes, 4);
        foreach ($index as $i) {
            $data[] = $allData[$shIndexes[$i]];
        }
        $dataFinal[] = $data;
        
        $this->view->items = $dataFinal;
    }

    public function contactsAction()
    {
        // action body
    }


}







