@TODO
Feature: Aqui podras encontrar los posibles escenarios parra un empleado

  Scenario: Obtener los empleados
    Given Camilo Inicia sesion en el sistema
    When Consulta los empleados
    Then Puede ver los empleados
      | nombreEmpleado  |
      | Tiger Nixon     |
      | Garrett Winters |
      | Ashton Cox      |

  Scenario Outline: Crear un empleado
    Given Camilo Inicia sesion en el sistema
    When Crea un empleado
      | nombreEmpleado   | salarioEmpleado   | edadEmpleado   |
      | <nombreEmpleado> | <salarioEmpleado> | <edadEmpleado> |
    Then Puede ver el empleado
      | nombreEmpleado   | salarioEmpleado   | edadEmpleado   |
      | <nombreEmpleado> | <salarioEmpleado> | <edadEmpleado> |

    Examples:
      | nombreEmpleado | salarioEmpleado | edadEmpleado |
      | Christian      | 6400000         | 35           |

  Scenario: Trear la infomración del primer empleado
    Given Camilo Inicia sesion en el sistema
    When Consulta el primer empleado
    Then Puede ver el empleado
      | nombreEmpleado | salarioEmpleado | edadEmpleado |
      | Tiger Nixon    | 320800          | 61           |

  Scenario: Actualizar la infomración de un empleado
    Given Camilo Inicia sesion en el sistema
    When Actualiza el empleado
      | idEmpleado | nombreEmpleado   | salarioEmpleado | edadEmpleado |
      | 1          | Christian Camilo | 6400000         | 35           |
    Then Puede ver el empleado
      | idEmpleado | nombreEmpleado   | salarioEmpleado | edadEmpleado |
      | 1          | Christian Camilo | 6400000         | 35           |