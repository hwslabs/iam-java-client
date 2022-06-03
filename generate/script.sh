files_path=".openapi-generator/FILES"
config_path="generate"
ignored_files=(".gitignore" "build.gradle" "pom.xml")

echo "Deleting old files....."
for f in $(cat $files_path) ; do
  [[ ! " ${ignored_files[*]} " =~ " $f " ]] && rm "$f"
done


echo "Generating new files....."
openapi-generator generate -g java -i $config_path/spec.yml -c $config_path/config.json --global-property modelTests=false,apiTests=false