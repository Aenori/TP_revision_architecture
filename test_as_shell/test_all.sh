set -eu

echo "####################"
echo " Starting tests ..."
echo "####################"

sync
set -x

curl 'http://localhost:8080/TP_real_project' 2>/dev/null

for page in Formateur Formation Annulation FusionFormation Remboursement RemplacementFormateur
do 
	url="http://localhost:8080/TP_real_project/"$page
	echo "Testing url : "$url
	result=$(curl $url 2>/dev/null)
	if [ -n "$(echo $result | grep -v 'HTTP Status 404 – Not Found')" ]
    then
      echo " : test"$page" OK !!"
    else
      echo " : test"$page" failed !!"
      exit 1
    fi
done

set +x
sync

echo "####################"
echo " Tests done !"
echo "####################"