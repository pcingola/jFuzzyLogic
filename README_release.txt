

										Release instructions
										--------------------


Main JAR file
-------------

  1) Create jFuzzyLogic.jar file
  
     Eclipse -> Package explorer -> jFuzzyLogic -> Select file jFuzzyLogic.jardesc -> Right click "Create JAR"

  2) Upload JAR file SourceForge (use sf.net menu)


HTML pages
----------

	1) Upload HTML pages to SourceForge

		cd ~/workspace/jFuzzyLogic
		scp index.html  pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/
		
		cd ~/workspace/jFuzzyLogic/html
		scp *.{html,css}  pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/html
		scp images/*.png  pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/html/images/
		scp videos/*.swf  pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/html/videos/
		scp -R assets dist fcl pdf pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/html/

Eclipse plugin
--------------

  1) Create small jFuzzyLogic.jar file (it's better to use a small file and not the big JAR file that has all source files)
  
		 cd ~/workspace/jFuzzyLogic/
		 ant
		 
		 # Check the JAR file
		 cd 
		 java -jar jFuzzyLogic.jar 


  2) Copy jFuzzyLogic.jar file to UI project

		cp jFuzzyLogic.jar net.sourceforge.jFuzzyLogic.Fcl.ui/lib/jFuzzyLogic.jar

  3) Build eclipse update site
  
	 In Eclipse:
	 	- In package explorer, refresh all net.sourceforge.jFuzzyLogic.Fcl.* projects

		- Open the net.sourceforge.jFuzzyLogic.Fcl.updateSite project
		- Delete the contents of the 'plugins' 'features' and dir
		
			cd ~/workspace/net.sourceforge.jFuzzyLogic.Fcl.updateSite
			rm -vf *.jar plugins/*.jar features/*.jar
		
		- Open site.xml file
			- Go to "Site Map" tab
			
			- Open jFuzzyLogic category and remove the 'feature' (called something like "net.sourceforge.jFuzzyLogic.Fcl.sdk_1.1.0.201212101535.jar" 
				and add it again (just to be sure)
				
			- Click the "Buid All" button
			
			- Refresh the project (you should see the JAR files in the plugin folders now).
		
  4) Upload Eclipse plugin files to SourceForge (Eclipse update site)
     
		cd ~/workspace/net.sourceforge.jFuzzyLogic.Fcl.updateSite
		scp -r . pcingola,jfuzzylogic@frs.sourceforge.net:htdocs/eclipse/
		
