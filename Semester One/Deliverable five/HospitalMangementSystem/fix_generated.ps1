$ErrorActionPreference = 'Stop'

$root = Join-Path $PSScriptRoot 'src'
if (-not (Test-Path $root)) {
  throw "src folder not found: $root"
}

$timestamp = Get-Date -Format 'yyyyMMdd_HHmmss'
$backup = "$root-backup_$timestamp"
Copy-Item -Path $root -Destination $backup -Recurse -Force
Write-Host "Backup created: $backup"

Get-ChildItem -Path $root -Recurse -Filter '*.java' | ForEach-Object {
  $path = $_.FullName

  $rel = $path.Substring($root.Length + 1) -replace '\\','/'

  $pkg = $null
  if ($rel -match '^(?<pkg>[^/]+)(?:/(?<sub>.+))?/[^/]+\.java$') {
    $pkg = $Matches['pkg']
    if ($Matches['sub']) {
      $pkg = $pkg + '.' + ($Matches['sub'] -replace '/','.')
    }
  }

  $content = Get-Content -Path $path -Raw

  $m = [regex]::Match($content, '(?m)^\s*public\s+(class|interface)\s+([A-Za-z_][A-Za-z0-9_]*)')
  if (-not $m.Success) {
    return
  }

  $kind = $m.Groups[1].Value
  $name = $m.Groups[2].Value

  $out = @()
  if ($pkg) {
    $out += "package $pkg;"
    $out += ''
  }

  if ($kind -eq 'interface') {
    $out += "public interface $name {"
    $out += "}"
  } else {
    $out += "public class $name {"
    $out += "    public $name() {"
    $out += "    }"
    $out += "}"
  }

  Set-Content -Path $path -Value $out -Encoding UTF8
}

Write-Host 'Done. All generated files converted to compilable shells.'
