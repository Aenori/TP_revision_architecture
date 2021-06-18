function test_form_page {
	testname=$1
	result_trimmed=$2
	action=$3

	if [ -z $(echo "$result_trimmed" | grep "action=\"$action\"") ]
	then
		echo "ERROR : "$testname" should contain an action redirecting to "$action
	    exit 1
	elif [ -z $(echo $result_trimmed | grep 'type="submit"') ]
	then
		echo "ERROR : "$testname" should contain a submit button"
		exit 1
	fi
}

function test_form_input {
	testname=$1
	result_trimmed=$2
	input_field_name=$3

	if [ -z $(echo "$result_trimmed" | grep "name=\"$input_field_name\"") ]
	then
		echo "ERROR : "$testname" should contain an input field with name "$input_field_name
		echo $result
		exit 1
	fi
}