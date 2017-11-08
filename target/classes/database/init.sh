clear

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/GeMA/init
echo ""
echo ""
echo "Finalizada la inicializacion de datos"
read -rsp $'Procediendo a Puestos, presione cualquier tecla para continuar...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/GeMA/user